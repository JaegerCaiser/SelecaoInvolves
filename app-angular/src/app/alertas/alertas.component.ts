import {Component, OnInit} from "@angular/core";
import {AlertasService} from "./alertas.service";
import {AlertaModel} from "./alertaModel";
import {Router} from "@angular/router";

@Component({
    selector: 'app-alertas',
    templateUrl: './alertas.component.html'
})
export class AlertasComponent implements OnInit {

    alertas: AlertaModel[] = []

    constructor(private alertasService: AlertasService, private router: Router) {
    }

    ngOnInit(): void {
        this.alertasService.alertas()
            .subscribe((alerta: AlertaModel[]) => this.alertas = alerta)
    }

    processar(): void {
        this.alertasService.processar()
            .subscribe((data) => {
                this.router.navigate(['/'])
            })
    }

}