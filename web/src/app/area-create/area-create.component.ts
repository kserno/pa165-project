import {Component, Inject, OnInit} from '@angular/core';
import {AreaService} from '../service/area.service';
import {FormBuilder, Validators} from '@angular/forms';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material';

interface AreaDialogData {
  area?: Area;
}

@Component({
  selector: 'app-area-create',
  templateUrl: './area-create.component.html',
  styleUrls: ['./area-create.component.css']
})
export class AreaCreateComponent implements OnInit {

  areaForm;
  isEdit = this.data !== null && this.data.area !== null;

  submitted = false;

  constructor(
    public dialogRef: MatDialogRef<AreaCreateComponent>,
    private areaService: AreaService,
    private formBuilder: FormBuilder,
    @Inject(MAT_DIALOG_DATA) private data?: AreaDialogData
    ) { }

  ngOnInit() {
    if (this.data !== null && this.data.area) {
      this.areaForm = this.formBuilder.group({
        name: [this.data.area.name, [Validators.required]],
        description: [this.data.area.description, [Validators.required]],
        image: [this.data.area.image]
      });
    } else {
      this.areaForm = this.formBuilder.group({
        name: ['', [Validators.required]],
        description: ['', [Validators.required]],
        image: []
      });
    }
  }

  onEdit() {
    this.submitted = true;

    if (this.areaForm.invalid) {
      return;
    }

    const data = this.areaForm.value;
    data.id = this.data.area.id;
    this.areaService.UpdateArea(data).subscribe((area) => {
      this.dialogRef.close();
    });
  }

  onSubmit() {
    this.submitted = true;

    if (this.areaForm.invalid) {
      return;
    }

    this.areaService.CreateArea(this.areaForm.value).subscribe((area) => {
      this.dialogRef.close();
    });
  }


  cancel() {
    this.dialogRef.close();
  }
}
