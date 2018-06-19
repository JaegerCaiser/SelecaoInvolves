import {Component, OnDestroy, OnInit} from "@angular/core";
import {AlertasService} from "./alertas.service";
import {AlertaModel} from "./alertaModel";
import {NavigationEnd, Router} from "@angular/router";
import {Subscription} from "rxjs/internal/Subscription";

@Component({
    selector: 'app-alertas',
    templateUrl: './alertas.component.html'
})
export class AlertasComponent implements OnInit, OnDestroy {

    alertas: AlertaModel[] = []
    private mySubscription: Subscription;

    constructor(private alertasService: AlertasService, private router: Router) {
        this.router.routeReuseStrategy.shouldReuseRoute = function () {
            return false;
        };

        this.mySubscription = this.router.events.subscribe((event) => {
            if (event instanceof NavigationEnd) {
                // Trick the Router into believing it's last link wasn't previously loaded
                this.router.navigated = false;
            }
        });
    }

    ngOnInit(): void {
        this.alertasService.alertas()
            .subscribe((alerta: AlertaModel[]) => this.alertas = alerta)
    }

    processar(): void {
        this.alertasService.processar()
            .subscribe((data) => {
                this.router.navigate(['/alertas'])
            })
    }

    ngOnDestroy(): void {
        if (this.mySubscription)
            this.mySubscription.unsubscribe();
    }

}