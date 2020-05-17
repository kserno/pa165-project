import { Component, OnInit } from '@angular/core';
import {AreaService} from '../service/area.service';
import {WeaponCreateComponent} from '../weapon-create/weapon-create.component';
import {AreaCreateComponent} from '../area-create/area-create.component';
import {MatDialog} from '@angular/material';
import {AuthService} from '../service/auth.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-areas',
  templateUrl: './areas.component.html',
  styleUrls: ['./areas.component.css']
})
export class AreasComponent implements OnInit {

  areas: Area[] = [];
  isAdmin = false;

  constructor(private areaService: AreaService,
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
    const dialogRef = this.dialog.open(AreaCreateComponent, {
      width: '400px'
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
      this.loadData();
    });
  }

  deleteArea($event, area: Area) {
    $event.stopPropagation();
    this.areaService.DeleteArea(area).subscribe((id) => {
      this.loadData();
    });
  }

  loadData() {
    this.areaService.GetAreas().subscribe((areas) => {
      this.areas = areas;
    });
  }

  editArea($event, area: Area) {
    $event.stopPropagation();
    const dialogRef = this.dialog.open(AreaCreateComponent, {
      width: '400px',
      data: {area}
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
      this.loadData();
    });
  }

  navigateToDetail(id: number) {
    this.router.navigate(['/areas/' + id]);
  }
}
