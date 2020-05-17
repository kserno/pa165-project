import { Component, OnInit } from '@angular/core';
import {UserService} from '../service/user.service';
import {AuthService} from '../service/auth.service';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {

  users: User[] = [];

  constructor(private userService: UserService,
              private authService: AuthService) { }

  ngOnInit() {
    this.userService.GetUsers().subscribe((users) => {
      this.users = users;
    });
  }

  changeUser(user: User) {
    this.authService.SaveUser(user);
  }
}
