import { Component, OnInit } from '@angular/core';
import {FormBuilder} from '@angular/forms';
import {UserService} from '../service/user.service';
import {AuthService} from '../service/auth.service';
import {log} from 'util';
import {Router} from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginForm;

  constructor(private formBuilder: FormBuilder, private userService: UserService,
              private authService: AuthService, private router: Router) {

  }

  ngOnInit() {
    if (this.authService.IsLoggedIn()) {
      this.navigateHome();
      return;
    }

    this.loginForm = this.formBuilder.group({
      email: '',
      password: ''
    });
  }

  onSubmit(loginData: FormData) {
    this.userService.Login(loginData).subscribe((user) => {
      this.authService.SaveUser(user);
      this.navigateHome();
    });

  }

  navigateHome() {
    this.router.navigate(['/']);
  }

}
