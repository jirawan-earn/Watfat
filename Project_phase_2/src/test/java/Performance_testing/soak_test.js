import http from 'k6/http';
import { check, sleep } from 'k6';

export let options = {
    duration: '30m',  // Run for 30 minutes
    vus: 10,          // 10 Virtual Users
};

export default function () {
    let response = http.get('http://45.136.236.146:8081/');
    check(response, {
        'status is 200': (r) => r.status === 200,
    });
    sleep(1);
}


//Soak Testing: ทดสอบการโหลดในระยะยาว (30 นาที)