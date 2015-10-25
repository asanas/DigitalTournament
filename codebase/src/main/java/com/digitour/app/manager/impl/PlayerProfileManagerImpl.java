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
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.digitour.app.dao.PlayerProfileDAO;
import com.digitour.app.db.model.PlayerProfile;
import com.digitour.app.db.model.Team;
import com.digitour.app.db.model.support.enums.Gender;
import com.digitour.app.db.model.support.enums.MajorSkill;
import com.digitour.app.db.model.support.enums.Role;
import com.digitour.app.manager.PlayerProfileManager;

@Service
public class PlayerProfileManagerImpl implements PlayerProfileManager {

    private static final Log log = LogFactory.getLog(PlayerProfileManagerImpl.class);
    
    @Autowired
    PlayerProfileDAO playerProfileDAO;
    
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
                        // skip first row
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
                        if (cell.getColumnIndex() == 1) {
                            playerProfile.setFirstName(cell.getStringCellValue());
                        }
                        else if (cell.getColumnIndex() == 2) {
                            playerProfile.setMiddleName(cell.getStringCellValue());
                        }
                        else if (cell.getColumnIndex() == 3) {
                            playerProfile.setLastName(cell.getStringCellValue());
                        }
                        // DOB
                        else if (cell.getColumnIndex() == 4) {
                            Date birthDt = cell.getDateCellValue();
                            playerProfile.setDateOfBirth(birthDt);
                        }
                        // GENDER
                        else if (cell.getColumnIndex() == 5) {
                            Gender gender = Gender.valueOf(cell.getStringCellValue().toUpperCase());
                            playerProfile.setGender(gender);
                        }
                        // height 
                        else if (cell.getColumnIndex() == 6) {
                            // in cms
                            playerProfile.setHeight(((Double)cell.getNumericCellValue()).intValue());
                        }
                        // weight
                        else if (cell.getColumnIndex() == 7 && Cell.CELL_TYPE_BLANK != cell.getCellType()) {
                            playerProfile.setWeight(cell.getNumericCellValue());
                        }
                        // MajorSkills
                        else if (cell.getColumnIndex() == 8 && Cell.CELL_TYPE_BLANK != cell.getCellType()) {
                            // MajorSkill
                            Role role = Role.valueOf(cell.getStringCellValue().toUpperCase().replaceAll(" ", ""));
                            playerProfile.setRole(role);
                        }
                        // total tournaments participated in
                        else if (cell.getColumnIndex() == 9 && Cell.CELL_TYPE_BLANK != cell.getCellType()) {
                            // tournaments participated in
                            playerProfile.setTotalToursParticipated(((Double)cell.getNumericCellValue()).intValue());
                        }
                        // achievements
                        else if (cell.getColumnIndex() == 10) {
                            // achievements
                            playerProfile.setAchievements(cell.getStringCellValue());
                        }
                     // email-id
                        else if (cell.getColumnIndex() == 11) {
                            // email id
                            playerProfile.setEmailId(cell.getStringCellValue());
                        }
                     // postal address
                        else if (cell.getColumnIndex() == 12) {
                            playerProfile.setAddress(cell.getStringCellValue());
                        }
                     // phone number
                        else if (cell.getColumnIndex() == 13) {
                            // contact numberd
                            String playerContact = NumberToTextConverter.toText(cell.getNumericCellValue());
                            playerProfile.setContact(playerContact);
                        }
                    }
                    playerProfile.setTeam(newTeam);
                    playerProfile.setCity(newTeam.getCity());
                    //end iterating a row, add all the elements of a row in list
                    playerProfileDAO.save(playerProfile);
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

    private MajorSkill findPlayerMajorSkill(String cellValue) {
        MajorSkill majorSkill = MajorSkill.DIVE;
        if(cellValue.equalsIgnoreCase(MajorSkill.DIVE.toString())) {
            majorSkill = MajorSkill.DIVE;
        } else if(cellValue.equalsIgnoreCase("Pole Dive")) {
            majorSkill = MajorSkill.POLEDIVE;
        } else if(cellValue.equalsIgnoreCase("Judgement Kho")) {
            majorSkill = MajorSkill.JUDGEMENTKHO;
        } else if(cellValue.equalsIgnoreCase("Sudden Attack")) {
            majorSkill = MajorSkill.SUDDENATTACK;
        } else if(cellValue.equalsIgnoreCase("Changes")) {
            majorSkill = MajorSkill.CHANGES;
        } else if(cellValue.equalsIgnoreCase(MajorSkill.DEFENCE.toString())) {
            majorSkill = MajorSkill.DEFENCE;
        } else if(cellValue.equalsIgnoreCase(MajorSkill.RING.toString())) {
            majorSkill = MajorSkill.RING;
        } else if(cellValue.equalsIgnoreCase(MajorSkill.ATTACK.toString())) {
            majorSkill = MajorSkill.ATTACK;
        } else if(cellValue.equalsIgnoreCase(MajorSkill.ROOT.toString())) {
            majorSkill = MajorSkill.ROOT;
        } else if(cellValue.equalsIgnoreCase(MajorSkill.ROOT.toString())) {
            majorSkill = MajorSkill.ROOT;
        }
        return majorSkill;
    }

    public File multipartToFile(MultipartFile multipart) throws IllegalStateException, IOException {
            File convFile = new File( multipart.getOriginalFilename());
            multipart.transferTo(convFile);
            return convFile;
    }

    @Override
    public PlayerProfile getById(Long playerProfileId) {
        return playerProfileDAO.getById(playerProfileId);
    }
}
