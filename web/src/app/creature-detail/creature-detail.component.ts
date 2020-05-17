import { Component, OnInit } from '@angular/core';
import {MatDialog} from '@angular/material';
import {ActivatedRoute} from '@angular/router';
import {AuthService} from '../service/auth.service';
import {EffectivenessCreateComponent} from '../effectiveness-create/effectiveness-create.component';
import {CreatureService} from '../service/creature.service';
import {AddCreatureAreaComponent} from '../add-creature-area/add-creature-area.component';

@Component({
  selector: 'app-creature-detail',
  templateUrl: './creature-detail.component.html',
  styleUrls: ['./creature-detail.component.css']
})
export class CreatureDetailComponent implements OnInit {

  creature: Creature;
  isAdmin = false;
  userId = -1;

  constructor(
    public dialog: MatDialog,
    private creatureService: CreatureService,
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
    this.creatureService.GetCreatureBy(id).subscribe((creature) => {
      this.creature = creature;
    });
  }

  removeEffectiveness(id) {
    this.creatureService.RemoveEffectiveness(this.creature.id, id).subscribe((id) => {
      this.loadData();
    });
  }

  addEffectivenessClicked() {
    const dialogRef = this.dialog.open(EffectivenessCreateComponent, {
      width: '400px',
      data: {creature: this.creature}
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
      this.loadData();
    });
  }

  addAreaClicked() {
    const dialogRef = this.dialog.open(AddCreatureAreaComponent, {
      width: '400px',
      data: {creature: this.creature}
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
      this.loadData();
    });
  }

  removeArea(id: number) {
    this.creatureService.RemoveArea(this.creature.id, id).subscribe(() => {
      this.loadData();
    });
  }
}
