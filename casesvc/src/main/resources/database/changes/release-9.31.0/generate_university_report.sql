﻿-- Function: casesvc.generate_university_report()

-- DROP FUNCTION casesvc.generate_university_report();

CREATE OR REPLACE FUNCTION casesvc.generate_university_report()
  RETURNS boolean AS
$BODY$
DECLARE
v_filename text;
v_directory text;
v_filedatestamp text;
v_report_query text;

BEGIN

   PERFORM casesvc.logmessage(p_messagetext := 'generate_university_report started'
                               ,p_jobid := 0   
                               ,p_messagelevel := 'INFO'
                               ,p_functionname := 'casesvc.generate_university_report');

 --NEED TO CHANGE TO CORRECT DIRECTORY WHEN KNOW WHERE FILE IS TO GO TO
 
 v_directory := '/var/helpline-mi/' ;

 v_filedatestamp := to_char(current_timestamp, 'DDMMYYYY_HHMM' );

 v_filename := 'university_report_' || v_filedatestamp  ;

 v_report_query := 'SELECT  c.caseref, a.organisation_name, a.address_line1, a.address_line2, a.locality, a.town_name, a.postcode
FROM casesvc.case c
,casesvc.casegroup cg
,casesvc.address a
WHERE c.state = ''ACTIONABLE''
AND a.sample = ''UNIVERSITY''
AND c.casegroupid = cg.casegroupid
AND cg.uprn = a.uprn';

  PERFORM casesvc.copy_csv(p_sql := v_report_query
			  ,p_directory := v_directory
			  ,p_filename := v_filename
			  ,p_header := 'HEADER'); 	

    PERFORM casesvc.logmessage(p_messagetext := 'generate_university_report completed'
                               ,p_jobid := 0   
                               ,p_messagelevel := 'INFO'
                               ,p_functionname := 'casesvc.generate_university_report');
  
  RETURN TRUE;

  EXCEPTION
  WHEN OTHERS THEN
   PERFORM casesvc.logmessage(p_messagetext := 'generate_university_report ' || sqlerrm
                               ,p_jobid := 0   
                               ,p_messagelevel := 'INFO'
                               ,p_functionname := 'casesvc.generate_university_report');
  RETURN FALSE;

END;
$BODY$
  LANGUAGE plpgsql VOLATILE SECURITY DEFINER
  COST 100;


