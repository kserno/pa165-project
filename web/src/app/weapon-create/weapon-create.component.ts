import {Component, Inject, OnInit} from '@angular/core';
import {WeaponService} from '../service/weapon.service';
import {FormBuilder} from '@angular/forms';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material';

interface WeaponDialogData {
  weapon?: Weapon;
}

@Component({
  selector: 'app-weapon-create',
  templateUrl: './weapon-create.component.html',
  styleUrls: ['./weapon-create.component.css']
})
export class WeaponCreateComponent implements OnInit {
  weaponForm;
  isEdit = this.data !== null && this.data.weapon !== null;

  constructor(public dialogRef: MatDialogRef<WeaponCreateComponent>,
              private weaponService: WeaponService,
              private formBuilder: FormBuilder,
              @Inject(MAT_DIALOG_DATA) private data?: WeaponDialogData) { }

  ngOnInit() {
    if (!this.isEdit) {
      this.weaponForm = this.formBuilder.group({
        name: [],
        gunReach: [],
        image: [],
        ammunitionType: []
      });
    } else {
      this.weaponForm = this.formBuilder.group({
        id: [this.data.weapon.id],
        name: [this.data.weapon.name],
        gunReach: [this.data.weapon.gunReach],
        image: [this.data.weapon.image],
        ammunitionType: [this.data.weapon.ammunitionType]
      });
    }
  }

  cancel() {
    this.dialogRef.close();
  }

  onSubmit() {
    this.weaponService.CreateWeapon(this.weaponForm.value).subscribe((weapon) => {
      this.dialogRef.close();
    });
  }
}
