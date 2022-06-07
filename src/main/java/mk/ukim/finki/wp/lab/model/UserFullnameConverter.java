package mk.ukim.finki.wp.lab.model;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import static javax.swing.plaf.synth.Region.SEPARATOR;

@Converter
public class UserFullnameConverter implements AttributeConverter<UserFullname, String> {


    @Override
    public String convertToDatabaseColumn(UserFullname userFullname) {
        if(userFullname == null){
            return null;
        }

        StringBuilder stringBuilder = new StringBuilder();
        if(userFullname.getSurname() != null && !userFullname.getSurname().isEmpty()){
            stringBuilder.append(userFullname.getSurname());
            stringBuilder.append(SEPARATOR);
        }

        if(userFullname.getName() != null && !userFullname.getName().isEmpty()){
            stringBuilder.append(userFullname.getName());
        }

        return stringBuilder.toString();
    }

    @Override
    public UserFullname convertToEntityAttribute(String dbUserFullName) {
        if (dbUserFullName == null || dbUserFullName.isEmpty()) {
            return null;
        }

        String[] pieces = dbUserFullName.split(String.valueOf(SEPARATOR));

        if (pieces == null || pieces.length == 0) {
            return null;
        }

        UserFullname userFullname = new UserFullname();
        String firstPiece = !pieces[0].isEmpty() ? pieces[0] : null;
        if (dbUserFullName.contains(String.valueOf(SEPARATOR))) {
            userFullname.setSurname(firstPiece);

            if (pieces.length >= 2 && pieces[1] != null && !pieces[1].isEmpty()) {
                userFullname.setName(pieces[1]);
            }
            } else {
                userFullname.setName(firstPiece);
            }

        return userFullname;
    }
}
