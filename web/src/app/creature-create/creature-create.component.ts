import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material';
import {CreatureService} from '../service/creature.service';
import {FormBuilder, FormControl, Validators} from '@angular/forms';

interface CreatureDialogData {
  creature?: Creature;
}

@Component({
  selector: 'app-creature-create',
  templateUrl: './creature-create.component.html',
  styleUrls: ['./creature-create.component.css']
})
export class CreatureCreateComponent implements OnInit {

  creatureForm;
  isEdit = this.data !== null && this.data.creature !== null;

  submitted = false;

  constructor(public dialogRef: MatDialogRef<CreatureCreateComponent>,
              private creatureService: CreatureService,
              private formBuilder: FormBuilder,
              @Inject(MAT_DIALOG_DATA) private data?: CreatureDialogData) { }


  ngOnInit() {
    if (this.data !== null && this.data.creature !== null) {
      this.creatureForm = this.formBuilder.group({
        id: [this.data.creature.id],
        name: [this.data.creature.name, [Validators.required]],
        height: [this.data.creature.height, [Validators.required]],
        weight: [this.data.creature.weight, [Validators.required]],
        agility: [this.data.creature.agility, [Validators.required]],
        image: [this.data.creature.image]
      });
    } else {
      this.creatureForm = this.formBuilder.group({
        name: ['', [Validators.required]],
        height: ['', [Validators.required]],
        agility: ['', [Validators.required]],
        weight: ['', [Validators.required]],
        image: []
      });
    }

  }

  onUpdate() {
    this.submitted = true;

    if (this.creatureForm.invalid) {
      return;
    }

    const data = this.creatureForm.value;
    this.creatureService.UpdateCreature(data).subscribe((creature) => {
      this.dialogRef.close();
    });
  }

  onSubmit() {
    this.submitted = true;

    if (this.creatureForm.invalid) {
      return;
    }

    this.creatureService.CreateCreature(this.creatureForm.value).subscribe((creature) => {
      this.dialogRef.close();
    });
  }

  cancel() {
    this.dialogRef.close();
  }
}
