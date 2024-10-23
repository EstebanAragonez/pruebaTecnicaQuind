package com.quind.model.validations;

import lombok.extern.slf4j.Slf4j;

import java.util.Calendar;
import java.util.Date;

@Slf4j
public class Validations {
    private Validations() {
        throw new IllegalStateException("Utility class");
    }

    public static void validarFechaSolicitud(String tipoSolicitudId, Date fechaDeseada) {
        Calendar fechaActual = Calendar.getInstance();
        fechaActual.setTime(new Date());

        Calendar fechaSolicitada = Calendar.getInstance();
        fechaSolicitada.setTime(fechaDeseada);

        long diferenciaEnMilisegundos = fechaSolicitada.getTimeInMillis() - fechaActual.getTimeInMillis();
        long diferenciaEnDias = diferenciaEnMilisegundos / (1000 * 60 * 60 * 24);

        if (tipoSolicitudId.equals("VC") || tipoSolicitudId.equals("DNR")) {
            // Validar que las solicitudes de vacaciones o días no remunerados tengan al menos 30 días de anticipación
            if (diferenciaEnDias < 30) {
                throw new IllegalArgumentException("Para el periodo de vacaciones o días no remunerados se requiere como mínimo realizar la solicitud 1 mes antes de la fecha deseada");
            }
        } else if (tipoSolicitudId.equals("AU")) {
            // Validar que las solicitudes de ausentismo tengan al menos 2 días de anticipación
            if (diferenciaEnDias < 2) {
                throw new IllegalArgumentException("Para permisos de ausentismo se requiere mínimo 2 días antes de la solicitud del permiso, en caso de ser una emergencia cambiar el tipo de solicitud a OS");
            }
        }
    }

    public static boolean estadoValido(String estado) {
        return estado.equalsIgnoreCase("NUEVA") ||
                estado.equalsIgnoreCase("APROBADA") ||
                estado.equalsIgnoreCase("EN PROCESO") ||
                estado.equalsIgnoreCase("DENEGADA");
    }


}
