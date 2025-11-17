
const BASE_URL = 'http://localhost:8080';


const menuSecretarias = document.getElementById('menu-secretarias');
const tituloSecretaria = document.getElementById('titulo-secretaria');
const descSecretaria = document.getElementById('descripcion-secretaria');
const panelAcciones = document.getElementById('panel-acciones');

const tablaDatos = document.getElementById('tabla-datos');
const tablaCabecera = document.getElementById('tabla-cabecera');
const tablaCuerpo = document.getElementById('tabla-cuerpo');


let secretariaActualId = null; 

document.addEventListener('DOMContentLoaded', () => {
    fetchSecretarias();
});


async function fetchSecretarias() {
    try {
       
        const response = await fetch(`${BASE_URL}/secretarias`);
        
        if (!response.ok) throw new Error('Error conectando con Java');
        
        const lista = await response.json();
        renderizarMenu(lista);

    } catch (error) {
        console.error(error);
        menuSecretarias.innerHTML = '<p>Error al cargar el menú.</p>';
    }
}


async function cargarDatos(tipo) {
    if (!secretariaActualId) return;

    
    let endpoint = '';

    if (tipo === 'eventos') {
     
        endpoint = `/eventos/filtrar/${secretariaActualId}`;
    } else if (tipo === 'miembros') {
  
        endpoint = `/miembros/filtrar/${secretariaActualId}`;
    } else if (tipo === 'recursos') {
      
        endpoint = `/recursos/filtrar/${secretariaActualId}`;
    }

    try {
        const response = await fetch(BASE_URL + endpoint);
        if (!response.ok) throw new Error(`Error obteniendo ${tipo}`);

        const datos = await response.json();
        renderizarTabla(datos, tipo);

    } catch (error) {
        console.error(error);
        tablaCuerpo.innerHTML = '<tr><td colspan="3">Error al cargar los datos. Revisa la consola.</td></tr>';
        tablaDatos.classList.remove('hidden');
    }
}



function renderizarMenu(listaSecretarias) {
    menuSecretarias.innerHTML = '';

    listaSecretarias.forEach(sec => {
        const btn = document.createElement('button');
        btn.innerText = sec.nombre; 
        btn.classList.add('btn-secretaria');
        
        btn.addEventListener('click', () => {
            seleccionarSecretaria(sec, btn);
        });

        menuSecretarias.appendChild(btn);
    });
}

function seleccionarSecretaria(secretaria, btn) {
    secretariaActualId = secretaria.id;

  
    tituloSecretaria.innerText = secretaria.nombre;
    descSecretaria.innerText = secretaria.descripcion || "Información de la secretaría.";

 
    document.querySelectorAll('.btn-secretaria').forEach(b => b.classList.remove('active'));
    btn.classList.add('active');


    panelAcciones.classList.remove('hidden');
    tablaDatos.classList.add('hidden');
}

function renderizarTabla(datos, tipo) {
    
    tablaCabecera.innerHTML = '';
    tablaCuerpo.innerHTML = '';
    
    let titulos = [];

    
    if (tipo === 'eventos') {
        titulos = ['Nombre', 'Fecha', 'Lugar'];
    } else if (tipo === 'miembros') {
        titulos = ['Nombre Completo', 'Cargo', 'Email'];
    } else if (tipo === 'recursos') {
        titulos = ['Recurso', 'Cantidad'];
    }

    // Dibujar Cabecera
    titulos.forEach(t => {
        const th = document.createElement('th');
        th.innerText = t;
        tablaCabecera.appendChild(th);
    });

    // 2. Dibujar las Filas (Datos)
    if (datos.length === 0) {
        tablaCuerpo.innerHTML = '<tr><td colspan="3">No hay datos disponibles.</td></tr>';
    } else {
        datos.forEach(item => {
            const tr = document.createElement('tr');
            
            if (tipo === 'eventos') {
             
                tr.innerHTML = `<td>${item.nombre}</td><td>${item.fecha}</td><td>${item.lugar}</td>`;
            
            } else if (tipo === 'miembros') {
             
                const nombre = item.estudiante?.nombre || 'S/N';
                const apellido = item.estudiante?.apellido || '';
                const email = item.estudiante?.email || '-';
                
                tr.innerHTML = `<td>${nombre} ${apellido}</td><td>${item.cargo}</td><td>${email}</td>`;
            
            } else if (tipo === 'recursos') {
                
                tr.innerHTML = `<td>${item.nombre_del_Recurso}</td><td>${item.cantidad}</td>`;
            }

            tablaCuerpo.appendChild(tr);
        });
    }

    tablaDatos.classList.remove('hidden');
}