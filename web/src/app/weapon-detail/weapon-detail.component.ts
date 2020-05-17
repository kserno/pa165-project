import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {WeaponService} from '../service/weapon.service';
import {AuthService} from '../service/auth.service';
import {MatDialog} from '@angular/material';
import {WeaponCreateComponent} from '../weapon-create/weapon-create.component';
import {EffectivenessCreateComponent} from '../effectiveness-create/effectiveness-create.component';

@Component({
  selector: 'app-weapon-detail',
  templateUrl: './weapon-detail.component.html',
  styleUrls: ['./weapon-detail.component.css']
})
export class WeaponDetailComponent implements OnInit {

  weapon: Weapon;
  isAdmin = false;
  userId = -1;

  constructor(
    public dialog: MatDialog,
    private weaponService: WeaponService,
    private route: ActivatedRoute,
    private authService: AuthService) { }

  ngOnInit() {
    this.initUser();
    this.loadData();
  }

  initUser() {
    this.isAdmin = this.authService.IsAdmin();
    this.userId = this.authService.GetUserId();
    this.authService.userObservable$.subscribe((user) => {
      this.isAdmin = this.authService.IsAdmin();
      this.userId = this.authService.GetUserId();
    });
  }

  loadData() {
    const id = this.route.snapshot.params.id;
    this.weaponService.GetWeaponBy(id).subscribe((weapon) => {
      this.weapon = weapon;
    });
  }

  removeEffectiveness(id) {
    this.weaponService.RemoveEffectiveness(this.weapon.id, id).subscribe((id) => {
      this.loadData();
    });
  }

  addEffectivenessClicked() {
    const dialogRef = this.dialog.open(EffectivenessCreateComponent, {
      width: '400px',
      data: {weapon: this.weapon}
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
      this.loadData();
    });
  }

}
