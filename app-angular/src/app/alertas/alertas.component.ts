import {Component, Input, OnInit} from "@angular/core";
import {AlertasService} from "./alertas.service";
import {AlertaModel} from "./alertaModel";

@Component({
    selector: 'app-alertas',
    templateUrl: './alertas.component.html'
})
export class AlertasComponent implements OnInit {

    alertas: AlertaModel[] = []

    constructor(private alertasService: AlertasService) {
    }

    ngOnInit(): void {
        this.alertasService.alertas()
            .subscribe((alerta: AlertaModel[]) => this.alertas = alerta)
    }

    processar(): void {
        this.alertasService.processar()
    }

}