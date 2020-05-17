import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {LoginComponent} from './login/login.component';
import {AreasComponent} from './areas/areas.component';
import {CreaturesComponent} from './creatures/creatures.component';
import {WeaponsComponent} from './weapons/weapons.component';
import {CreatureDetailComponent} from './creature-detail/creature-detail.component';
import {WeaponDetailComponent} from './weapon-detail/weapon-detail.component';
import {UsersComponent} from './users/users.component';
import {AreaDetailComponent} from './area-detail/area-detail.component';
import {UserDetailComponent} from './user-detail/user-detail.component'; // CLI imports router

const routes: Routes = [
  { path: '', redirectTo: '/areas', pathMatch: 'full'},
  { path: 'login', component: LoginComponent },
  { path: 'areas', component: AreasComponent},
  { path: 'weapons', component: WeaponsComponent },
  { path: 'creatures', component: CreaturesComponent},
  { path: 'users', component: UsersComponent},
  { path: 'areas/:id', component: AreaDetailComponent },
  { path: 'creatures/:id', component: CreatureDetailComponent },
  { path: 'weapons/:id', component: WeaponDetailComponent },
  { path: 'users/:id', component: UserDetailComponent },
  { path: 'me', component: UserDetailComponent }
  // { path: '**', component: PageNotFoundComponent }
]; // sets up routes constant where you define your routes

// configures NgModule imports and exports
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
