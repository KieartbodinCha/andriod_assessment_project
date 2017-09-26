package com.example.nook.assessment.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.nook.assessment.model.School;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DatabaseSchool extends SQLiteOpenHelper {
    private static final String DB_NAME = "Asses3";
    private static final int DB_VERSION = 12;
    private static final String DB_TABLE = "School";

    public DatabaseSchool(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        StringBuilder sqlCreateTable = new StringBuilder(" CREATE TABLE " + DB_TABLE);

        sqlCreateTable.append(" ( ");
        sqlCreateTable.append(" ID INTEGER PRIMARY KEY AUTOINCREMENT, ");
        sqlCreateTable.append(" PLACE_NAME TEXT, ");
        sqlCreateTable.append(" CANTEEN_NAME TEXT, ");
        sqlCreateTable.append(" OWNER_NAME TEXT, ");
        sqlCreateTable.append(" DEPARTMENT_NAME TEXT, ");
        sqlCreateTable.append(" ADDRESS TEXT, ");
        sqlCreateTable.append(" DISTRICT TEXT, ");
        sqlCreateTable.append(" SUB_DISTRICT TEXT, ");
        sqlCreateTable.append(" PROVINCE TEXT, ");
        sqlCreateTable.append(" STUDENT_COUNT TEXT, ");
        sqlCreateTable.append(" CUSTOMER_COUNT TEXT, ");
        sqlCreateTable.append(" OPERATION_COUNT TEXT, ");
        sqlCreateTable.append(" ASSESSOR_NAME TEXT, ");
        sqlCreateTable.append(" ASSESSMENT_COUNT TEXT, ");
        sqlCreateTable.append(" ASSESSMENT_DATE TEXT, ");
        sqlCreateTable.append(" BASIC_TRAIN TEXT, ");
        sqlCreateTable.append(" BASIC_SERVICE_TYPE TEXT, ");
        sqlCreateTable.append(" BASIC_LUNCH_ORGANIZE TEXT, ");
        sqlCreateTable.append(" CHOICE1 TEXT, CHOICE2 TEXT, CHOICE3 TEXT, CHOICE4 TEXT, CHOICE5 TEXT, ");
        sqlCreateTable.append(" CHOICE6 TEXT, CHOICE7 TEXT, CHOICE8 TEXT, CHOICE9 TEXT, CHOICE10 TEXT, ");
        sqlCreateTable.append(" CHOICE11 TEXT, CHOICE12 TEXT, CHOICE13 TEXT, CHOICE14 TEXT, CHOICE15 TEXT, ");
        sqlCreateTable.append(" CHOICE16 TEXT, CHOICE17 TEXT, CHOICE18 TEXT, CHOICE19 TEXT, CHOICE20 TEXT, ");
        sqlCreateTable.append(" CHOICE21 TEXT, CHOICE22 TEXT, CHOICE23 TEXT, CHOICE24 TEXT, CHOICE25 TEXT, ");
        sqlCreateTable.append(" CHOICE26 TEXT, CHOICE27 TEXT, CHOICE28 TEXT, CHOICE29 TEXT, CHOICE30 TEXT, ");
        sqlCreateTable.append(" COMMENT1 TEXT, COMMENT2 TEXT, COMMENT3 TEXT, COMMENT4 TEXT, COMMENT5 TEXT, ");
        sqlCreateTable.append(" COMMENT6 TEXT, COMMENT7 TEXT, COMMENT8 TEXT, COMMENT9 TEXT, COMMENT10 TEXT, ");
        sqlCreateTable.append(" COMMENT11 TEXT, COMMENT12 TEXT, COMMENT13 TEXT, COMMENT14 TEXT, COMMENT15 TEXT, ");
        sqlCreateTable.append(" COMMENT16 TEXT, COMMENT17 TEXT, COMMENT18 TEXT, COMMENT19 TEXT, COMMENT20 TEXT, ");
        sqlCreateTable.append(" COMMENT21 TEXT, COMMENT22 TEXT, COMMENT23 TEXT, COMMENT24 TEXT, COMMENT25 TEXT, ");
        sqlCreateTable.append(" COMMENT26 TEXT, COMMENT27 TEXT, COMMENT28 TEXT, COMMENT29 TEXT, COMMENT30 TEXT, ");
        sqlCreateTable.append(" IMAGE1 BLOB, IMAGE2 BLOB, IMAGE3 BLOB, IMAGE4 BLOB, ");
        sqlCreateTable.append(" RESULT TEXT ");

        sqlCreateTable.append(" ); ");

        db.execSQL(sqlCreateTable.toString());
        Log.d("CREATE TABLE", "Create Table Successfully.");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DB_TABLE);
        onCreate(db);
    }

    public HashMap<String, Object> SelectData(String id) {
        HashMap<String, Object> currentRow = new HashMap<String, Object>();
        SQLiteDatabase databaseConnection = null;
        try {
            databaseConnection = getReadableDatabase();
            Cursor cursor = databaseConnection.query(DB_TABLE, new String[]{"*"},
                    "ID=?",
                    new String[]{String.valueOf(id)}, null, null, null, null);

            if (cursor != null) {
                if (cursor.moveToFirst()) {
                    for (int i = 0; i < cursor.getColumnCount(); i++) {
                        try {
                            if (cursor.getType(i) == Cursor.FIELD_TYPE_STRING) {
                                currentRow.put(cursor.getColumnName(i), cursor.getString(i));
                            } else if (cursor.getType(i) == Cursor.FIELD_TYPE_BLOB) {
                                currentRow.put(cursor.getColumnName(i), cursor.getBlob(i));
                            } else if (cursor.getType(i) == Cursor.FIELD_TYPE_INTEGER) {
                                currentRow.put(cursor.getColumnName(i), cursor.getInt(i));
                            } else if (cursor.getType(i) == Cursor.FIELD_TYPE_FLOAT) {
                                currentRow.put(cursor.getColumnName(i), cursor.getFloat(i));
                            } else if (cursor.getType(i) == Cursor.FIELD_TYPE_NULL) {
                                currentRow.put(cursor.getColumnName(i), null);
                            }
                        } catch (Exception e) {
                            Log.e(e.getMessage(), e.getMessage(), e);
                        }
                    }
                }
            }
            cursor.close();
        } catch (Exception e) {
            Log.e(e.getMessage(), e.getMessage(), e);
        } finally {
            if (databaseConnection != null) {
                databaseConnection.close();
            }
        }
        return currentRow;
    }

    // Show All Data
    public List<HashMap<String, Object>> SelectAllData() {
        List<HashMap<String, Object>> rows = new ArrayList<HashMap<String, Object>>();
        SQLiteDatabase databaseConnection = null;
        try {
            databaseConnection = getReadableDatabase();
            String strSQL = "SELECT  * FROM " + DB_TABLE;
            Cursor cursor = databaseConnection.rawQuery(strSQL, null);
            if (cursor != null) {
                if (cursor.moveToFirst()) {
                    do {
                        HashMap<String, Object> currentRow = new HashMap<String, Object>();
                        for (int i = 0; i < cursor.getColumnCount(); i++) {
                            if (cursor.getType(i) == Cursor.FIELD_TYPE_STRING) {
                                currentRow.put(cursor.getColumnName(i), cursor.getString(i));
                            } else if (cursor.getType(i) == Cursor.FIELD_TYPE_BLOB) {
                                currentRow.put(cursor.getColumnName(i), cursor.getBlob(i));
                            } else if (cursor.getType(i) == Cursor.FIELD_TYPE_INTEGER) {
                                currentRow.put(cursor.getColumnName(i), cursor.getInt(i));
                            } else if (cursor.getType(i) == Cursor.FIELD_TYPE_FLOAT) {
                                currentRow.put(cursor.getColumnName(i), cursor.getFloat(i));
                            } else if (cursor.getType(i) == Cursor.FIELD_TYPE_NULL) {
                                currentRow.put(cursor.getColumnName(i), null);
                            }
                        }
                        rows.add(currentRow);
                    } while (cursor.moveToNext());
                }
                cursor.close();
            }
        } catch (Exception e) {
            Log.e(e.getMessage(), e.getMessage(), e);
        } finally {
            if (databaseConnection != null) {
                databaseConnection.close();
            }
        }
        return rows;
    }

    public long insertData(School school) {
        long rows = 0L;
        SQLiteDatabase databaseConnection = null;
        try {
            databaseConnection = getWritableDatabase();
            ContentValues contentValues = new ContentValues();

            contentValues.put("PLACE_NAME", school.getPlaceName());
            contentValues.put("CANTEEN_NAME", school.getCanteenName());
            contentValues.put("OWNER_NAME", school.getOwnerName());
            contentValues.put("DEPARTMENT_NAME", school.getDepartmentName());
            contentValues.put("ADDRESS", school.getAddressName());
            contentValues.put("DISTRICT", school.getDistrict());
            contentValues.put("SUB_DISTRICT", school.getSubDistrict());
            contentValues.put("PROVINCE", school.getProvince());
            contentValues.put("STUDENT_COUNT", school.getStudentCount());
            contentValues.put("CUSTOMER_COUNT", school.getCustomerCount());
            contentValues.put("OPERATION_COUNT", school.getOperationCount());
            contentValues.put("ASSESSOR_NAME", school.getAssessorName());
            contentValues.put("ASSESSMENT_COUNT", school.getAssessmentCount());
            contentValues.put("ASSESSMENT_DATE", school.getAssessmentDate());
            contentValues.put("BASIC_TRAIN", school.getBasicTrain());
            contentValues.put("BASIC_SERVICE_TYPE", school.getBasicServiceType());
            contentValues.put("BASIC_LUNCH_ORGANIZE", school.getBasicLunchOrganize());

            contentValues.put("CHOICE1", school.getChoice1());
            contentValues.put("CHOICE2", school.getChoice2());
            contentValues.put("CHOICE3", school.getChoice3());
            contentValues.put("CHOICE4", school.getChoice4());
            contentValues.put("CHOICE5", school.getChoice5());
            contentValues.put("CHOICE6", school.getChoice6());
            contentValues.put("CHOICE7", school.getChoice7());
            contentValues.put("CHOICE8", school.getChoice8());
            contentValues.put("CHOICE9", school.getChoice9());
            contentValues.put("CHOICE10", school.getChoice10());

            contentValues.put("CHOICE11", school.getChoice11());
            contentValues.put("CHOICE12", school.getChoice12());
            contentValues.put("CHOICE13", school.getChoice13());
            contentValues.put("CHOICE14", school.getChoice14());
            contentValues.put("CHOICE15", school.getChoice15());
            contentValues.put("CHOICE16", school.getChoice16());
            contentValues.put("CHOICE17", school.getChoice17());
            contentValues.put("CHOICE18", school.getChoice18());
            contentValues.put("CHOICE19", school.getChoice19());
            contentValues.put("CHOICE20", school.getChoice20());

            contentValues.put("CHOICE21", school.getChoice21());
            contentValues.put("CHOICE22", school.getChoice22());
            contentValues.put("CHOICE23", school.getChoice23());
            contentValues.put("CHOICE24", school.getChoice24());
            contentValues.put("CHOICE25", school.getChoice25());
            contentValues.put("CHOICE26", school.getChoice26());
            contentValues.put("CHOICE27", school.getChoice27());
            contentValues.put("CHOICE28", school.getChoice28());
            contentValues.put("CHOICE29", school.getChoice29());
            contentValues.put("CHOICE30", school.getChoice30());

            contentValues.put("COMMENT1", school.getComment1());
            contentValues.put("COMMENT2", school.getComment2());
            contentValues.put("COMMENT3", school.getComment3());
            contentValues.put("COMMENT4", school.getComment4());
            contentValues.put("COMMENT5", school.getComment5());
            contentValues.put("COMMENT6", school.getComment6());
            contentValues.put("COMMENT7", school.getComment7());
            contentValues.put("COMMENT8", school.getComment8());
            contentValues.put("COMMENT9", school.getComment9());
            contentValues.put("COMMENT10", school.getComment10());

            contentValues.put("COMMENT11", school.getComment11());
            contentValues.put("COMMENT12", school.getComment12());
            contentValues.put("COMMENT13", school.getComment13());
            contentValues.put("COMMENT14", school.getComment14());
            contentValues.put("COMMENT15", school.getComment15());
            contentValues.put("COMMENT16", school.getComment16());
            contentValues.put("COMMENT17", school.getComment17());
            contentValues.put("COMMENT18", school.getComment18());
            contentValues.put("COMMENT19", school.getComment19());
            contentValues.put("COMMENT20", school.getComment20());

            contentValues.put("COMMENT21", school.getComment21());
            contentValues.put("COMMENT22", school.getComment22());
            contentValues.put("COMMENT23", school.getComment23());
            contentValues.put("COMMENT24", school.getComment24());
            contentValues.put("COMMENT25", school.getComment25());
            contentValues.put("COMMENT26", school.getComment26());
            contentValues.put("COMMENT27", school.getComment27());
            contentValues.put("COMMENT28", school.getComment28());
            contentValues.put("COMMENT29", school.getComment29());
            contentValues.put("COMMENT30", school.getComment30());

            contentValues.put("IMAGE1", school.getImg1());
            contentValues.put("IMAGE2", school.getImg2());
            contentValues.put("IMAGE3", school.getImg3());
            contentValues.put("IMAGE4", school.getImg4());

            contentValues.put("RESULT", school.getResult());

            rows = databaseConnection.insert(DB_TABLE, null, contentValues);
        } catch (Exception e) {
            Log.e(e.getMessage(), e.getMessage(), e);
        } finally {
            if (databaseConnection != null) {
                databaseConnection.close();
            }
        }
        return rows;
    }


}