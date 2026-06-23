package mat.dev.sprinboot.util;

import org.postgresql.util.PSQLException;
import org.postgresql.util.ServerErrorMessage;

public class ExceptionUtils {

    public static String extrairMensagem(RuntimeException ex) {

        Throwable causa = ex;

        while (causa != null) {

            if (causa instanceof PSQLException psqle) {

                ServerErrorMessage erro = psqle.getServerErrorMessage();

                if (erro != null) {

                    if (erro.getDetail() != null && !erro.getDetail().isBlank()) {
                        return erro.getDetail();
                    }

                    if (erro.getMessage() != null && !erro.getMessage().isBlank()) {
                        return erro.getMessage();
                    }
                }

                return psqle.getMessage();
            }

            causa = causa.getCause();
        }

        return ex.getMessage();
    }

}