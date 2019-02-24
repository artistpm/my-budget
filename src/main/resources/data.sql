-- USERS
-- '89f4a48a-1db7-48fa-9f46-c810a9ffc349'

-- uuid_generate_v4()
INSERT INTO users (id, authority,created, pwrd, username, login_date) VALUES(random_uuid(),1,NOW(),'batukan2','artistpm@gmail.com', NOW());

--CURRENCY
INSERT INTO currency(id, currency_name, is_default, created) VALUES (1, 'HUF', true, now());

--LANGUAGE
INSERT INTO language(id, name, created) VALUES(1, 'hu', now());

--RESOURCES
INSERT INTO resources(id, language_id, resource_key, resource_name, created) VALUES(1, 1, 'valami.valami:egy', 'Hát ez valami!', now());

-- COSTS
INSERT INTO cost (id,cost_label, cost_name, cost_value, description, other_identifier, payed, payment_deadline, currency_id, payment_period_id, user_id)
VALUES(
1, 'autóhitel', 'autóhitel', 35432, '', '', true, '2023-01-20', 1, 1, (select u.id from users u where username = 'artistpm@gmail.com')
);
--
INSERT INTO cost (id,cost_label, cost_name, cost_value, description, other_identifier, payed, payment_deadline, currency_id, payment_period_id, user_id)
VALUES(
2, 'elmű', 'villanyszámla', 5432, '', '', false, '2019-02-10', 1, 1, (select u.id from users u where username = 'artistpm@gmail.com')
);