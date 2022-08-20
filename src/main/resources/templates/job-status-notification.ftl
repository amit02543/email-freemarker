<!DOCTYPE>
<html>
	<head>
		<title>Job Status Notification</title>

		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />

		<link href="https://fonts.googleapis.com/css?family=Titillium+Web&display=swap" rel="stylesheet">
		
		<style>
			.jumbo {
				text-align: center;
				text-decoration: underline;
				margin-bottom: 1em;
			}
		
			table {
			  font-family: arial, sans-serif;
			  border-collapse: collapse;
			  width: 100%;
			}

			td, th {
			  border: 1px solid #dddddd;
			  text-align: left;
			  padding: 8px;
			  word-break: break-all;
			}
			
			th {
				text-align: center;
				font-weight: bold;
			}

			tr:nth-child(even) {
			  background-color: #dddddd;
			}
			
			.header {
				background-color: rgb(148, 110, 58);
				color: #fff;
			}
			
			.success {
			   //background-color: rgba(0, 255, 0, 0.6);
			}
			
			.error {
			  color: rgba(255, 0, 0, 0.6);
			}
			
		</style>

	</head>

	<body>
		<h2 class="jumbo">JOB Status</h2>
		<table>
			<thead>
				<tr class="header">
					<th width="5%">Id</th>
					<th width="15%">Name</th>
					<th width="10%">Start Time</th>
					<th width="10%">End Time</th>
					<th width="10%">Total Records</th>
					<th width="10%">Total Errors</th>
					<th width="10%">Run Status</th>
					<th width="15%">Error Type</th>
					<th width="15%">Exception Message</th>
				</tr>
			</thead>
			<tbody>
				<#list jobStatuses as jobStatus>
					
					<#assign runStatus>error</#assign>
					<#if jobStatus.run_status == 'SUCCESS'>
					  <#assign runStatus>success</#assign>
					</#if>
					
					<tr class="${runStatus}">
						<td>${jobStatus.id}</td>
						<td>${jobStatus.name}</td>
						<td>${jobStatus.start_time}</td>
						<td>${jobStatus.end_time}</td>
						<td>${jobStatus.total_records}</td>
						<td>${("${jobStatus.total_errors}")!' '}</td>
						<td>${jobStatus.run_status}</td>
						<td>${("${jobStatus.error_type}")!' '}</td>
						<td>${("${jobStatus.exception_message}")!' '}</td>
					</tr>
					
				</#list>
			</tbody>
		</table>
			
	</body>

</html>