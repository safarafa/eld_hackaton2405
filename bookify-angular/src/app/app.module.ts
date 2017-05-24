import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { RouterModule, Routes } from '@angular/router';

import { AppComponent } from './app.component';
import { ReservationComponent } from './reservation/reservation.component';
import { RoomsComponent } from './rooms/rooms.component';
import { SummarizeComponent } from './summarize/summarize.component';

const appRoutes: Routes = [
  {
    path: 'reservation',
    component: ReservationComponent
  },
  {
    path: 'summarize/:rooms/:people/:price/:location/:hotel',
    component: SummarizeComponent
  },
  {
    path: 'rooms/:rooms/:people/:price/:location',
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
    RoomsComponent,
    SummarizeComponent
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
