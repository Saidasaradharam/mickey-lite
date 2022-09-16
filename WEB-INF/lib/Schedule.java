package student;

import com.adventnet.persistence.*;
import com.adventnet.mfw.bean.BeanUtil;
import com.adventnet.taskengine.*;

public class Schedule{
    public void ScheduleTask() throws DataAccessException{
        try{
            System.out.println("Inside ScheduleTask Function ");
            Persistence pers = (Persistence) BeanUtil.lookup("Persistence");
            DataObject data = pers.constructDataObject();

            Row taskengineRow = new Row(TASKENGINE_TASK.TABLE);
            taskengineRow.set(TASKENGINE_TASK.TASK_NAME_IDX,"Sampletask");
            taskengineRow.set(TASKENGINE_TASK.CLASS_NAME_IDX,"sampletask.SampleTask");

            Row scheduleRow = new Row(SCHEDULE.TABLE);
            scheduleRow.set(SCHEDULE.SCHEDULE_NAME_IDX,"Sample");

            Row scheduledTaskRow = new Row(SCHEDULED_TASK.TABLE);
            scheduledTaskRow.set(SCHEDULED_TASK.SCHEDULE_ID_IDX,scheduleRow.get(SCHEDULE.SCHEDULE_ID_IDX));
            scheduledTaskRow.set(SCHEDULED_TASK.TASK_ID_IDX,taskengineRow.get(TASKENGINE_TASK.TASK_ID_IDX));
            scheduledTaskRow.set(SCHEDULED_TASK.RETRY_HANDLER,"com.adventnet.taskengine.internal.DefaultScheduleRetryHandler");
            Row scheduledTaskRetryRow = new Row(SCHEDULEDTASK_RETRY.TABLE);
            scheduledTaskRetryRow.set(SCHEDULEDTASK_RETRY.SCHEDULE_ID_IDX ,scheduleRow.get(SCHEDULE.SCHEDULE_ID_IDX));
            scheduledTaskRetryRow.set(SCHEDULEDTASK_RETRY.TASK_ID_IDX,taskengineRow.get(TASKENGINE_TASK.TASK_ID_IDX));
            scheduledTaskRetryRow.set(SCHEDULEDTASK_RETRY.RETRY_COUNT,5);
            scheduledTaskRetryRow.set(SCHEDULEDTASK_RETRY.RETRY_FACTOR,5);
            scheduledTaskRetryRow.set(SCHEDULEDTASK_RETRY.RETRY_TIME_PERIOD,10);
            scheduledTaskRetryRow.set(SCHEDULEDTASK_RETRY.RETRY_UNIT_OF_TIME,"minutes");
            data.addRow(scheduledTaskRetryRow);

            Row periodicRow = new Row(PERIODIC.TABLE);
            periodicRow.set(PERIODIC.SCHEDULE_ID_IDX, scheduleRow.get(SCHEDULE.SCHEDULE_ID_IDX));
            periodicRow.set(PERIODIC.START_DATE_IDX,"2018-08-06 01:00:00.0");
            // java.sql.Timestamp object.
            periodicRow.set(PERIODIC.END_DATE_IDX,"2028-09-30 01:00:00.0");
            // java.sql.Timestamp object.
            periodicRow.set(PERIODIC.TIME_PERIOD_IDX,1);
            periodicRow.set(PERIODIC.UNIT_OF_TIME_IDX,"minutes");

            data.addRow(taskengineRow);
            data.addRow(scheduleRow);
            data.addRow(periodicRow);
            data.addRow(scheduledTaskRow);
            pers.add(data);

            Scheduler s = (Scheduler) BeanUtil.lookup("Scheduler");
            DataObject taskInputDO = pers.constructDataObject();
            Row taskInputRow = new Row(TASK_INPUT.TABLE);
            taskInputDO.addRow(taskInputRow);

            // If needed, you can also add 'Default_Task_Input' rows to the above taskInputDO

            s.scheduleTask("Sample","Sampletask",taskInputDO);

            System.out.println("Scheduling Successfull");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
} 