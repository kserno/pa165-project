import { Component, OnInit } from '@angular/core';
import {UserService} from '../service/user.service';
import {ActivatedRoute} from '@angular/router';
import {AuthService} from '../service/auth.service';

@Component({
  selector: 'app-user-detail',
  templateUrl: './user-detail.component.html',
  styleUrls: ['./user-detail.component.css']
})
export class UserDetailComponent implements OnInit {

  image: any = null;
  imageFormat = '';
  user: User;

  constructor(private userService: UserService,
              private authService: AuthService,
              private route: ActivatedRoute) { }

  ngOnInit() {
    this.loadData();
  }

  loadData() {
    const id = this.route.snapshot.params.id;
    if (id == null) {
      this.userService.GetUserById(this.authService.GetUserId()).subscribe((user) => {
        this.user = user;
      });
    } else {
      this.userService.GetUserById(id).subscribe((user) => {
        this.user = user;
      });
    }
  }

  changeImage() {
    if (this.image != null) {
      const user = { userId: this.user.id, image: this.image, imageMimeType: this.imageFormat};
      this.userService.ChangeImage(user).subscribe((user) => {
        this.user = user;
      });
    }
  }

  setImage(imageInput: any) {
    const file: File = imageInput.files[0];
    const reader = new FileReader();

    reader.addEventListener('load', (event: any) => {

      this.image = btoa(String.fromCharCode.apply(null, new Uint8Array(event.target.result)));
      this.imageFormat = file.type;

    });

    reader.readAsArrayBuffer(file);
  }
}
