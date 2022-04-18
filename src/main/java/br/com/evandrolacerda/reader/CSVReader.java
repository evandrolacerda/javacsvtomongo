package br.com.evandrolacerda.reader;

import br.com.evandrolacerda.reader.pojo.Address;

import java.io.*;
import java.util.*;

public class CSVReader {

    public List<Address> getList( ) throws IOException {

            InputStream inputStream = new FileInputStream("/importar.csv");
            Reader inputStreamReader = new InputStreamReader( inputStream );

            BufferedReader bufferedReader = new BufferedReader( inputStreamReader );
            List<Address> addressList = new ArrayList<>();

            String linha = bufferedReader.readLine();

            while( linha != null ){

                Address address = convertToAddressObject( linha );

                addressList.add( address );

                linha = bufferedReader.readLine();
            }

            bufferedReader.close();

            return addressList;

    }

    private Address convertToAddressObject(String csvLine ) {
        String[] fields = csvLine.split(",");

        for( int i = 0; i < fields.length; i++ ){
            fields[i] = fields[i].trim().replaceAll("\\s+", " ").replace("\"", "");
        }

        String cep = fields[4];
        String endereco = fields[5];
        String numero = fields[6];
        String complemento = fields[7];
        String bairro = fields[8];
        String cidade;
        cidade = toTitleCase( fields[9] );
        String estado = toTitleCase( fields[10] );

        Address address = new Address();
        address.setBairro( bairro );
        address.setCep( cep );
        address.setEndereco( endereco );
        address.setNumber( numero );
        address.setComplemento(complemento);
        address.setEstado( estado );
        address.setCidade( cidade );

        return address;
    }

    private String toTitleCase( String stringToConvert )
    {
        if( stringToConvert.length() == 0 ){
            return stringToConvert;
        }

        stringToConvert = stringToConvert.toLowerCase().replaceAll("\\s+", " ");

        String[] stringParts = stringToConvert.split(" ");
        StringBuilder builder = new StringBuilder( stringToConvert.length() );

        String[] juncoes = {"de", "dos", "das", "da", "do"};

        for ( String part : stringParts )
        {

            if(Arrays.asList(juncoes).contains(part.trim())){

                builder.append( part );
                builder.append( " ");
                continue;
            }

            String firstLetter = part.substring(0,1).toUpperCase();
            String rest = part.substring(1);
            builder.append( firstLetter );
            builder.append( rest );
            builder.append( " " );

        }

        return builder.toString().trim();
    }
}
