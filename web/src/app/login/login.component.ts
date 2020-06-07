import { Component, OnInit } from '@angular/core';
import {FormBuilder} from '@angular/forms';
import {UserService} from '../service/user.service';
import {AuthService} from '../service/auth.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginForm;

  error: string = null;

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
    }, body => {
      const error = body.error;
      if (error != null && error.errors != null && error.errors.length > 0) {
        this.error = error.errors[0];
      } else {
        this.error = null;
      }
    });

  }

  navigateHome() {
    this.router.navigate(['/']);
  }

}
