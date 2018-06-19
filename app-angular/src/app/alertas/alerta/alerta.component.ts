import {Component, Input, OnInit} from "@angular/core";
import {AlertaModel} from "../alertaModel";
@Component({
    selector: 'app-alerta',
    templateUrl: './alerta.component.html'
})
export class AlertaComponent implements OnInit {
    @Input() alerta: AlertaModel

    ngOnInit(): void {
    }
}