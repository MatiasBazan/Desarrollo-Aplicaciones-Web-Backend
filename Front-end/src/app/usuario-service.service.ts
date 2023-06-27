import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class UsuarioServiceService {

  constructor(private http: HttpClient) { 
    
  }
  obtenerDatos() {
    return this.http.get('http://localhost:8080/espacioFisico');
  }
}
