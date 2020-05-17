import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material';
import {FormBuilder} from '@angular/forms';
import {CreatureService} from '../service/creature.service';
import {WeaponService} from '../service/weapon.service';
import {AuthService} from '../service/auth.service';

interface EffectivenessDialogData {
  weapon?: Weapon;
  creature?: Creature;
}

@Component({
  selector: 'app-effectiveness-create',
  templateUrl: './effectiveness-create.component.html',
  styleUrls: ['./effectiveness-create.component.css']
})
export class EffectivenessCreateComponent implements OnInit {
  effectivenessForm;

  weapons: Weapon[] = [];
  creatures: Creature[] = [];

  constructor(public dialogRef: MatDialogRef<EffectivenessCreateComponent>,
              @Inject(MAT_DIALOG_DATA) private data: EffectivenessDialogData,
              private formBuilder: FormBuilder,
              private authService: AuthService,
              private weaponService: WeaponService,
              private creatureService: CreatureService) { }

  ngOnInit() {
    this.loadData();
    console.log(this.data);
    if (this.data.weapon == null) {
      this.effectivenessForm = this.formBuilder.group({
          rating: [],
          weaponId: []
      });
    } else {
      this.effectivenessForm = this.formBuilder.group({
        rating: [],
        creatureId: []
      });
    }
  }

  cancel() {
    this.dialogRef.close();
  }

  onSubmit() {
    const formData = this.effectivenessForm.value;
    formData.userId = this.authService.GetUserId();
    if (this.data.weapon == null) {
      this.creatureService.AddEffectiveness(this.data.creature.id, formData).subscribe((creature) => {
        this.dialogRef.close();
      });
    } else {
      this.weaponService.AddEffectiveness(this.data.weapon.id, formData).subscribe((weapon) => {
        this.dialogRef.close();
      });
    }
  }

  private loadData() {
    this.weaponService.GetWeapons().subscribe((weapons) => {
      this.weapons = weapons;
    });
    this.creatureService.GetCreatures().subscribe((creatures) => {
      this.creatures = creatures;
    });
  }
}
