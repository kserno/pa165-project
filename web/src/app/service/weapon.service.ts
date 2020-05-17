import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {environment} from '../../environments/environment';

const API_URL = environment.api_url + '/weapons/';

@Injectable({
  providedIn: 'root'
})
export class WeaponService {

  constructor(private http: HttpClient) {
  }

  GetWeapons(): Observable<Weapon[]> {
    return this.http.get<Weapon[]>(API_URL);
  }

  DeleteWeapon(weapon: Weapon): Observable<number> {
    return this.http.delete<number>(API_URL + weapon.id);
  }

  CreateWeapon(weapon: Weapon): Observable<Weapon> {
    return this.http.post(API_URL, weapon);
  }

  GetWeaponBy(id: number): Observable<Weapon> {
    return this.http.get(API_URL + id);
  }

  RemoveEffectiveness(weaponId: number, effectivenessId: number): Observable<number> {
    return this.http.delete<number>(API_URL + weaponId + '/effectiveness/' + effectivenessId);
  }

  AddEffectiveness(id: number, effectiveness: FormData): Observable<void> {
    return this.http.post<void>(API_URL + id + '/effectiveness/', effectiveness);
  }
}

