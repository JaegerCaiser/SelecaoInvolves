import {Injectable} from "@angular/core";
import {AlertaModel} from "./alertaModel";
import {INVOLVES_API} from "../app.api";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/internal/Observable";

@Injectable()
export class AlertasService {

    constructor(private http: HttpClient) {
    }

    alertas(): Observable<AlertaModel[]> {
        return this.http.get<AlertaModel[]>(`${INVOLVES_API}/alertas`)
    }

    processar(): Observable<any> {
        return this.http.get(`${INVOLVES_API}/alertas/processar`)
    }
}