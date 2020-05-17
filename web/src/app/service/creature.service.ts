import { Injectable } from '@angular/core';
import {environment} from '../../environments/environment';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';


const API_URL = environment.api_url + '/creatures/';

@Injectable({
  providedIn: 'root'
})
export class CreatureService {

  constructor(private http: HttpClient) { }

  GetCreatures(): Observable<Creature[]> {
    return this.http.get<Creature[]>(API_URL);
  }

  DeleteCreature(creature: Creature): Observable<number> {
    return this.http.delete<number>(API_URL + creature.id);
  }

  UpdateCreature(creature: Creature): Observable<Creature> {
    return this.http.put<Creature>(API_URL + creature.id, creature);
  }

  CreateCreature(creature: Creature): Observable<Creature> {
    return this.http.post<Creature>(API_URL, creature);
  }

  AddEffectiveness(id: number, effectiveness: FormData): Observable<void> {
    return this.http.post<void>(API_URL + id + '/effectiveness/', effectiveness);
  }

  RemoveEffectiveness(id: number, effectivenessId: number): Observable<number> {
    return this.http.delete<number>(API_URL + id + '/effectiveness/' + effectivenessId);
  }

  AddArea(id: number, areaId: number): Observable<number> {
    return this.http.post<number>(API_URL + id + '/areas/' + areaId, {});
  }

  RemoveArea(id: number, areaId: number): Observable<number> {
    return this.http.delete<number>(API_URL + id + '/areas/' + areaId);
  }

  GetCreatureBy(id: number): Observable<Creature> {
    return this.http.get<Creature>(API_URL + id);
  }
}
