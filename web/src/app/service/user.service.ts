import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {environment} from '../../environments/environment';

const API_URL = environment.api_url;

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }

  Login(loginData: FormData): Observable<User> {
    return this.http.post<User>(API_URL + '/users/auth', loginData);
  }

  GetUsers(): Observable<User[]> {
    return this.http.get<User[]>(API_URL + '/users');
  }

  GetUserById(id: number): Observable<User> {
    return this.http.get<User>(API_URL + '/users/'+id);
  }

  ChangeImage(user) {
    return this.http.post<User>(API_URL + '/users/changeImage', user);

  }
}
