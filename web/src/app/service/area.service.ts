import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';
import {environment} from '../../environments/environment';


const API_URL = environment.api_url + '/areas/';
@Injectable({
  providedIn: 'root'
})
export class AreaService {

  constructor(private http: HttpClient) { }

  GetAreas(): Observable<Area[]> {
    return this.http.get<Area[]>(API_URL);
  }

  CreateArea(area: Area): Observable<Area> {
    return this.http.post<Area>(API_URL, area);
  }

  UpdateArea(area: Area): Observable<Area> {
    return this.http.put(API_URL + area.id, area);
  }

  DeleteArea(area: Area): Observable<number> {
    return this.http.delete<number>(API_URL + area.id);
  }

  AddCreature(id: number, creatureId: number): Observable<number> {
    return this.http.post<number>(API_URL + id + '/creatures/' + creatureId, {});
  }

  RemoveCreature(id: number, creatureId: number): Observable<number> {
    return this.http.delete<number>(API_URL + id + '/creatures/' + creatureId);
  }

  GetAreaBy(id: number) {
    return this.http.get<Area>(API_URL + id);
  }
}
