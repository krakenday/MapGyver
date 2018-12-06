package test.uc4Voyage.dao;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestServiceCrudVoyage.class, TestServiceCrudPOI.class,TestServiceCrudRoadBook.class })
public class AllTestUC4Voyage {

}