import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {HomeComponent} from "./home/home.component";
import {RouterModule} from "@angular/router";
import {ROUTES} from "./app.routers";
import {HttpClientModule} from "@angular/common/http";
import {AlertasComponent} from "./alertas/alertas.component";
import {AlertaComponent} from "./alertas/alerta/alerta.component";
import {AlertasService} from "src/app/alertas/alertas.service";

@NgModule({
    declarations: [
        AppComponent,
        HomeComponent,
        AlertasComponent,
        AlertaComponent
    ],
    imports: [
        BrowserModule,
        HttpClientModule,
        RouterModule.forRoot(ROUTES)
    ],
    providers: [AlertasService],
    bootstrap: [AppComponent]
})
export class AppModule {
}
