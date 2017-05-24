import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { RouterModule, Routes } from '@angular/router';

import { AppComponent } from './app.component';
import { ReservationComponent } from './reservation/reservation.component';
import { RoomsComponent } from './rooms/rooms.component';

const appRoutes: Routes = [
  {
    path: 'reservation',
    component: ReservationComponent
  },
  {
    path: 'rooms',
    component: RoomsComponent
  },
  { 
    path: '',
    redirectTo: '/reservation',
    pathMatch: 'full'
  },
];

@NgModule({
  declarations: [
    AppComponent,
    ReservationComponent,
    RoomsComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
