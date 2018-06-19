import {Routes} from "@angular/router";
import {HomeComponent} from "./home/home.component";
import {AlertasComponent} from "./alertas/alertas.component";

export const ROUTES: Routes = [
    {path: '', component: HomeComponent},
    {path: 'alertas', component: AlertasComponent}
]