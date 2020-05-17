import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { MatToolbarModule } from '@angular/material/toolbar';
import { MatTabsModule} from '@angular/material/tabs';
import { MatCardModule } from '@angular/material/card';

import { AppRoutingModule } from './app-routing.module';
import { WeaponsComponent } from './weapons/weapons.component';
import { WeaponDetailComponent } from './weapon-detail/weapon-detail.component';
import { AreasComponent } from './areas/areas.component';
import { CreaturesComponent } from './creatures/creatures.component';
import { CreatureDetailComponent } from './creature-detail/creature-detail.component';
import { LoginComponent } from './login/login.component';
import {HttpClientModule} from '@angular/common/http';
import {
  MatButtonModule,
  MatDialogModule,
  MatFormFieldModule,
  MatGridListModule,
  MatIconModule,
  MatInputModule, MatListModule, MatSelectModule,
  MatSidenavModule, MatSliderModule
} from '@angular/material';
import { CreatureCreateComponent } from './creature-create/creature-create.component';
import { WeaponCreateComponent } from './weapon-create/weapon-create.component';
import { AreaCreateComponent } from './area-create/area-create.component';
import {ReactiveFormsModule} from '@angular/forms';
import { UsersComponent } from './users/users.component';
import { EffectivenessCreateComponent } from './effectiveness-create/effectiveness-create.component';
import { AddCreatureAreaComponent } from './add-creature-area/add-creature-area.component';
import { AreaDetailComponent } from './area-detail/area-detail.component';
import { UserDetailComponent } from './user-detail/user-detail.component';

@NgModule({
  declarations: [
    AppComponent,
    WeaponsComponent,
    WeaponDetailComponent,
    AreasComponent,
    CreaturesComponent,
    CreatureDetailComponent,
    LoginComponent,
    CreatureCreateComponent,
    WeaponCreateComponent,
    AreaCreateComponent,
    UsersComponent,
    EffectivenessCreateComponent,
    AddCreatureAreaComponent,
    AreaDetailComponent,
    UserDetailComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    HttpClientModule,
    MatToolbarModule,
    MatTabsModule,
    AppRoutingModule,
    MatCardModule,
    MatGridListModule,
    MatButtonModule,
    MatDialogModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    MatInputModule,
    MatIconModule,
    MatSidenavModule,
    MatListModule,
    MatSelectModule,
    MatSliderModule
  ],
  providers: [],
  bootstrap: [AppComponent],
  entryComponents: [
    AreaCreateComponent,
    CreatureCreateComponent,
    WeaponCreateComponent,
    EffectivenessCreateComponent,
    AddCreatureAreaComponent
  ]
})
export class AppModule { }
