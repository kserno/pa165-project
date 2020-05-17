import { Injectable } from '@angular/core';
import {Subject} from 'rxjs';

const USER = 'logged_user';


@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private user: User = null;
  private userSubject = new Subject<User>();

  userObservable$ = this.userSubject.asObservable();

  constructor() { }

  SaveUser(user: User) {
    this.user = user;
    localStorage.setItem(USER, JSON.stringify(user));
    this.userSubject.next(user);
  }

  LogOut() {
    this.user = null;
    localStorage.removeItem(USER);
    this.userSubject.next(this.user);
  }

  GetUser(): User {
    if (this.user == null) {
      this.user = JSON.parse(localStorage.getItem(USER));
    }
    return this.user;
  }

  GetUserId() {
    if (this.GetUser() == null) {
      return -1;
    }
    return this.GetUser().id;
  }



  IsLoggedIn() {
    return this.GetUser() != null;
  }

  IsAdmin(): boolean {
    console.log(this.GetUser());
    if (this.GetUser() == null) {
      return false;
    }
    return this.GetUser().admin;
  }

}
