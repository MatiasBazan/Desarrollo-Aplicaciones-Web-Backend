import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { UsuarioServiceService } from '../usuario-service.service';


@Component({
  selector: 'app-primer-componente',
  templateUrl: './primer-componente.component.html',
  styleUrls: ['./primer-componente.component.css']
})
export class PrimerComponenteComponent {
  edad = 0;
  datos :any= [];
  sumarEdad(){
    this.edad +=1;
  }
  restarEdad(){
    this.edad -=1;
  }
  
  constructor(private usuarioService: UsuarioServiceService) { 

  }
    ngOnInit(){
      this.usuarioService.obtenerDatos().subscribe(
        response => {
          console.log(response)
          this.datos = response;
        }
      )
    }
}
