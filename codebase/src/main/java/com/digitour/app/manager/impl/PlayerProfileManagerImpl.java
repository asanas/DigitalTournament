package com.digitour.app.manager.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.digitour.app.db.model.PlayerProfile;
import com.digitour.app.db.model.Team;
import com.digitour.app.db.model.support.enums.Gender;
import com.digitour.app.db.model.support.enums.MajorSkill;
import com.digitour.app.db.model.support.enums.Role;
import com.digitour.app.manager.PlayerProfileManager;

@Service
public class PlayerProfileManagerImpl implements PlayerProfileManager {

    private static final Log log = LogFactory.getLog(PlayerProfileManagerImpl.class);
    
    @Override
    public void addPlayersListToTeam(Team newTeam, MultipartFile multipartfile) {
        try {
            File file = multipartToFile(multipartfile);
            FileInputStream fileInputStream = new FileInputStream(file);
            // Using XSSF for xlsx format, for xls use HSSF
            Workbook workbook = new XSSFWorkbook(fileInputStream);

            List<PlayerProfile> lstPlayers = new ArrayList<>();
            int numberOfSheets = workbook.getNumberOfSheets();
            //looping over each workbook sheet
            for (int i = 0; i < numberOfSheets; i++) {
                Sheet sheet = workbook.getSheetAt(i);
                Iterator<Row> rowIterator = sheet.iterator();
                //iterating over each row
                int rowNumber = 1;
                while (rowIterator.hasNext()) {
                    Row row = null;
                    if(rowNumber == 1) {
                        row = (Row) rowIterator.next();
                        rowNumber++;
                    }
                    PlayerProfile playerProfile = new PlayerProfile();
                    row = (Row) rowIterator.next();
                    Iterator<Cell> cellIterator = row.cellIterator();

                    //Iterating over each cell (column wise)  in a particular row.
                    while (cellIterator.hasNext()) {
                        
                        Cell cell = (Cell) cellIterator.next();
                        Date birthDate = new Date();
                        playerProfile.setDateOfBirth(birthDate);
                        //Cell with index 1 contains First name
                        if (cell.getColumnIndex() == 1) {
                            playerProfile.setFirstName(cell.getStringCellValue());
                        }
                        //Cell with index 2 contains marks in Science
                        else if (cell.getColumnIndex() == 2) {
                            playerProfile.setMiddleName(cell.getStringCellValue());
                        }
                        //Cell with index 3 contains marks in English
                        else if (cell.getColumnIndex() == 3) {
                            playerProfile.setLastName(cell.getStringCellValue());
                        }
                        // DOB
                        else if (cell.getColumnIndex() == 4) {
                            // TODO: set players birth date. 16-06-1986 - > 16-Jun-1986
                        }
                        // GENDER
                        else if (cell.getColumnIndex() == 5) {
                            Gender gender = null;
                            if(cell.getStringCellValue().equals(Gender.MALE.toString())) {
                                gender = Gender.MALE;
                            } else {
                                gender = Gender.FEMALE;
                            }
                            playerProfile.setGender(gender);
                        }
                        // height 
                        else if (cell.getColumnIndex() == 6) {
                            // TODO in cms
                            playerProfile.setHeight(((Double)cell.getNumericCellValue()).intValue());
                        }
                        // weight
                        else if (cell.getColumnIndex() == 7) {
                            playerProfile.setWeight(cell.getNumericCellValue());
                        }
                        // MajorSkills
                        else if (cell.getColumnIndex() == 8) {
                            // TODO : MajorSkill
                            playerProfile.setMajorSkill(MajorSkill.DIVE);
                        }
                        // Role
                        else if (cell.getColumnIndex() == 9) {
                            // TODO : role
                            playerProfile.setRole(Role.ALLROUNDER);
                        }
                        // Role
                        else if (cell.getColumnIndex() == 10) {
                            // TODO : tournaments participated in
                            playerProfile.setTotalToursParticipated(((Double)cell.getNumericCellValue()).intValue());
                        }
                        // Role
                        else if (cell.getColumnIndex() == 11) {
                            // TODO : achievements
                            playerProfile.setAchievements(cell.getStringCellValue());
                        }
                     // email-id
                        else if (cell.getColumnIndex() == 12) {
                            // TODO : email id
                        }
                     // postal address
                        else if (cell.getColumnIndex() == 13) {
                            // TODO : postal address
                        }
                     // postal address
                        else if (cell.getColumnIndex() == 14) {
                            // TODO : contact number
                            playerProfile.setContact(String.valueOf(cell.getNumericCellValue()));
                        }
                    }
                    //end iterating a row, add all the elements of a row in list
                    lstPlayers.add(playerProfile);
                }
            }
            log.debug("Total players added to the team - "+lstPlayers.size());
            fileInputStream.close();
        } catch (IllegalStateException e) {
            log.error("Error occured while reading multipart file.", e);
        } catch (IOException e) {
            log.error("Error occured while reading multipart file.", e);
        }
        
    }

    public File multipartToFile(MultipartFile multipart) throws IllegalStateException, IOException {
            File convFile = new File( multipart.getOriginalFilename());
            multipart.transferTo(convFile);
            return convFile;
    }
}
