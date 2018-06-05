select a.value, s.program, s.username, s.sid, s.serial#
from v$sesstat a, v$statname b, v$session s
where a.statistic# = b.statistic#  and s.sid=a.sid
and b.name = 'opened cursors current'
/*and s.username = 'VOOD'
and s.program like '%JDBC%'*/
order by 1 desc



