import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SelectCsvComponent } from './select-csv/select-csv.component';
import { SelectDataComponent } from './select-data/select-data.component';

@NgModule({
  declarations: [
    AppComponent,
    SelectCsvComponent,
    SelectDataComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
