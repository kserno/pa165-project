import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material';
import {FormBuilder} from '@angular/forms';
import {AuthService} from '../service/auth.service';
import {CreatureService} from '../service/creature.service';
import {AreaService} from '../service/area.service';

interface CreatureAreaDialogData {
  creature?: Creature;
  area?: Area;
}

@Component({
  selector: 'app-add-creature-area',
  templateUrl: './add-creature-area.component.html',
  styleUrls: ['./add-creature-area.component.css']
})
export class AddCreatureAreaComponent implements OnInit {

  areaCreatureForm;

  areas: Area[] = [];
  creatures: Creature[] = [];

  constructor(public dialogRef: MatDialogRef<AddCreatureAreaComponent>,
              @Inject(MAT_DIALOG_DATA) private data: CreatureAreaDialogData,
              private formBuilder: FormBuilder,
              private authService: AuthService,
              private areaService: AreaService,
              private creatureService: CreatureService) { }

  ngOnInit() {
    this.loadData();
    if (this.data.area == null) {
      this.areaCreatureForm = this.formBuilder.group({
        rating: [],
        areaId: []
      });
    } else {
      this.areaCreatureForm = this.formBuilder.group({
        rating: [],
        creatureId: []
      });
    }
  }

  cancel() {
    this.dialogRef.close();
  }

  onSubmit() {
    const formData = this.areaCreatureForm.value;
    // formData.userId = this.authService.GetUserId();
    if (this.data.area == null) {
      this.creatureService.AddArea(this.data.creature.id, formData.areaId).subscribe((creature) => {
        this.dialogRef.close();
      });
    } else {
      this.areaService.AddCreature(this.data.area.id, formData.creatureId).subscribe((weapon) => {
        this.dialogRef.close();
      });
    }
  }

  private loadData() {
    this.areaService.GetAreas().subscribe((areas) => {
      this.areas = areas;
    });
    this.creatureService.GetCreatures().subscribe((creatures) => {
      this.creatures = creatures;
    });
  }

}
