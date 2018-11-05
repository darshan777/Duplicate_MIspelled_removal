import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpModule } from '@angular/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SelectCsvComponent } from './select-csv/select-csv.component';
import { SelectDataComponent } from './select-data/select-data.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { Routes, RouterModule } from '@angular/router';
import { CsvServiceService } from "./service/csv-service.service";
import  { HttpClientModule } from "@angular/common/http";
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';

const appRoutes: Routes = [
  { path: '', component: SelectCsvComponent },
  { path: 'selectData', component: SelectDataComponent }
];

@NgModule({
  declarations: [
    AppComponent,
    SelectCsvComponent,
    SelectDataComponent,
    HeaderComponent,
    FooterComponent


  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule.forRoot(appRoutes),
    HttpModule,
    HttpClientModule


  ],
  providers: [
    CsvServiceService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
