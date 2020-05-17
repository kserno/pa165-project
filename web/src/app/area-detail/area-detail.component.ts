import { Component, OnInit } from '@angular/core';
import {MatDialog} from '@angular/material';
import {ActivatedRoute} from '@angular/router';
import {AuthService} from '../service/auth.service';
import {AreaService} from '../service/area.service';
import {AddCreatureAreaComponent} from '../add-creature-area/add-creature-area.component';

@Component({
  selector: 'app-area-detail',
  templateUrl: './area-detail.component.html',
  styleUrls: ['./area-detail.component.css']
})
export class AreaDetailComponent implements OnInit {

  area: Area;
  isAdmin = false;
  userId = -1;

  constructor(
    public dialog: MatDialog,
    private areaService: AreaService,
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
    this.areaService.GetAreaBy(id).subscribe((area) => {
      this.area = area;
    });
  }

  removeCreature(id) {
    this.areaService.RemoveCreature(this.area.id, id).subscribe((id) => {
      this.loadData();
    });
  }

  addCreatureClicked() {
    const dialogRef = this.dialog.open(AddCreatureAreaComponent, {
      width: '400px',
      data: {area: this.area}
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
      this.loadData();
    });
  }
}
