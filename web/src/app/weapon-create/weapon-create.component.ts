import {Component, Inject, OnInit} from '@angular/core';
import {WeaponService} from '../service/weapon.service';
import {FormBuilder, Validators} from '@angular/forms';
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

  submitted = false;

  constructor(public dialogRef: MatDialogRef<WeaponCreateComponent>,
              private weaponService: WeaponService,
              private formBuilder: FormBuilder,
              @Inject(MAT_DIALOG_DATA) private data?: WeaponDialogData) { }

  ngOnInit() {
    if (!this.isEdit) {
      this.weaponForm = this.formBuilder.group({
        name: ['', Validators.required],
        gunReach: ['', Validators.required],
        image: [],
        ammunitionType: ['', Validators.required]
      });
    } else {
      this.weaponForm = this.formBuilder.group({
        id: [this.data.weapon.id],
        name: [this.data.weapon.name, Validators.required],
        gunReach: [this.data.weapon.gunReach, Validators.required],
        image: [this.data.weapon.image],
        ammunitionType: [this.data.weapon.ammunitionType, Validators.required]
      });
    }
  }

  cancel() {
    this.dialogRef.close();
  }

  onSubmit() {
    this.submitted = true;

    if (this.weaponForm.invalid) {
      return;
    }

    this.weaponService.CreateWeapon(this.weaponForm.value).subscribe((weapon) => {
      this.dialogRef.close();
    });
  }

  onEdit() {
    this.submitted = true;

    if (this.weaponForm.invalid) {
      return;
    }
    const data = this.weaponForm.value;
    data.id = this.data.weapon.id;

    this.weaponService.UpdateWeapon(data).subscribe((weapon) => {
      this.dialogRef.close();
    });
  }
}
