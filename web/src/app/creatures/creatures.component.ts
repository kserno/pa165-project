import { Component, OnInit } from '@angular/core';
import {CreatureService} from '../service/creature.service';
import {AuthService} from '../service/auth.service';
import {WeaponCreateComponent} from '../weapon-create/weapon-create.component';
import {MatDialog} from '@angular/material';
import {CreatureCreateComponent} from '../creature-create/creature-create.component';
import {Router} from '@angular/router';

@Component({
  selector: 'app-creatures',
  templateUrl: './creatures.component.html',
  styleUrls: ['./creatures.component.css']
})
export class CreaturesComponent implements OnInit {

  creatures: Creature[] = [];
  isAdmin = false;

  constructor(private creatureService: CreatureService,
              private authService: AuthService,
              private dialog: MatDialog,
              private router: Router) { }

  ngOnInit() {
    this.isAdmin = this.authService.IsAdmin();
    this.authService.userObservable$.subscribe((user) => {
      this.isAdmin = this.authService.IsAdmin();
    });
    this.loadData();
  }

  createClicked() {
    const dialogRef = this.dialog.open(CreatureCreateComponent, {
      width: '400px'
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
      this.loadData();
    });
  }

  loadData() {
    this.creatureService.GetCreatures().subscribe((creatures) => {
      this.creatures = creatures;
    });
  }

  deleteCreature($event, creature: Creature) {
    $event.stopPropagation();
    this.creatureService.DeleteCreature(creature).subscribe((id) => {
      this.loadData();
    });
  }

  editCreature($event, creature: Creature) {
    $event.stopPropagation();
    const dialogRef = this.dialog.open(CreatureCreateComponent, {
      width: '400px',
      data: {creature}
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
      this.loadData();
    });
  }

  navigateToDetail(id: number) {
    this.router.navigate(['creatures/' + id]);
  }
}
