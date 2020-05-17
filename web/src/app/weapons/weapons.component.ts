import { Component, OnInit } from '@angular/core';
import {WeaponService} from '../service/weapon.service';
import {MatDialog} from '@angular/material';
import {WeaponCreateComponent} from '../weapon-create/weapon-create.component';
import {AuthService} from '../service/auth.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-weapons',
  templateUrl: './weapons.component.html',
  styleUrls: ['./weapons.component.css']
})
export class WeaponsComponent implements OnInit {

  weapons: Weapon[] = [];
  isAdmin = false;

  constructor(private weaponService: WeaponService,
              private authService: AuthService,
              public dialog: MatDialog,
              private router: Router) { }

  ngOnInit() {
    this.isAdmin = this.authService.IsAdmin();
    this.authService.userObservable$.subscribe((user) => {
      this.isAdmin = this.authService.IsAdmin();
    });
    this.loadData();
  }

  createClicked() {
    const dialogRef = this.dialog.open(WeaponCreateComponent, {
      width: '400px'
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
      this.loadData();
    });
  }

  loadData() {
    this.weaponService.GetWeapons().subscribe((weapons) => {
      this.weapons = weapons;
    });
  }

  deleteWeapon($event, weapon: Weapon) {
    $event.stopPropagation();
    this.weaponService.DeleteWeapon(weapon).subscribe((id) => {
      this.loadData();
    });
  }

  navigateToDetail(id: number) {
    this.router.navigate(['/weapons/' + id]);
  }

  editWeapon($event, weapon: Weapon) {
    $event.stopPropagation();
    const dialogRef = this.dialog.open(WeaponCreateComponent, {
      width: '400px',
      data: { weapon }
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
      this.loadData();
    });
  }
}
