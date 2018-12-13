package test.uc4Voyage.dao;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({TestServiceCrudRoadBook.class, TestServiceCrudVoyage.class, TestServiceCrudPOI.class,TestFactoryEntity.class })
public class AllTestUC4Voyage {

}