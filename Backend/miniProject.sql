create database farm;
use farm;
drop database farm;
show tables;
alter table user AUTO_INCREMENT = 1000;
select * from users;
select * from otp_verification;
truncate equipment_images;
truncate equipment;
INSERT INTO schemes
(title, short_description, detailed_summary, category, target_group, state, language,
 official_url, apply_url, active)
VALUES
('PM-KISAN',
 'Income support to farmers',
 'Provides ₹6000 per year in three equal installments to eligible farmer families.',
 'FINANCIAL',
 'FARMER',
 'ALL',
 'en',
 'https://pmkisan.gov.in',
 'https://pmkisan.gov.in/RegistrationForm.aspx',
 true),

('Pradhan Mantri Fasal Bima Yojana',
 'Crop insurance scheme',
 'Provides insurance coverage against crop failure due to natural calamities.',
 'INSURANCE',
 'FARMER',
 'ALL',
 'en',
 'https://pmfby.gov.in',
 'https://pmfby.gov.in',
 true),

('Soil Health Card Scheme',
 'Improve soil fertility',
 'Provides soil testing and nutrient recommendations to farmers.',
 'SUBSIDY',
 'FARMER',
 'ALL',
 'en',
 'https://soilhealth.dac.gov.in',
 'https://soilhealth.dac.gov.in/home',
 true),

('Kisan Credit Card',
 'Easy credit for farmers',
 'Provides short-term credit to farmers for agricultural needs.',
 'FINANCIAL',
 'FARMER',
 'ALL',
 'en',
 'https://www.myscheme.gov.in/schemes/kcc',
 'https://www.myscheme.gov.in/schemes/kcc',
 true),

('PM Krishi Sinchai Yojana',
 'Irrigation support',
 'Aims to improve farm productivity through better irrigation facilities.',
 'SUBSIDY',
 'FARMER',
 'ALL',
 'en',
 'https://pmksy.gov.in',
 'https://pmksy.gov.in',
 true);

INSERT INTO schemes
(title, short_description, detailed_summary, category, target_group, state, language,
 official_url, apply_url, active)
VALUES
('Mahatma Jyotiba Phule Shetkari Karj Mukti Yojana',
 'Loan waiver for farmers',
 'Provides loan waiver to eligible farmers in Maharashtra.',
 'FINANCIAL',
 'FARMER',
 'MAHARASHTRA',
 'mr',
 'https://mahadbt.maharashtra.gov.in',
 'https://mahadbt.maharashtra.gov.in',
 true),

('Magel Tyala Shet Tale',
 'Farm pond scheme',
 'Supports construction of farm ponds to improve irrigation.',
 'SUBSIDY',
 'FARMER',
 'MAHARASHTRA',
 'mr',
 'https://www.maharashtra.gov.in',
 'https://www.maharashtra.gov.in',
 true),

('Rajiv Gandhi Shetkari Apghat Vima Yojana',
 'Accident insurance for farmers',
 'Provides insurance coverage to farmers in case of accidental death.',
 'INSURANCE',
 'FARMER',
 'MAHARASHTRA',
 'mr',
 'https://krushi.maharashtra.gov.in',
 'https://krushi.maharashtra.gov.in',
 true);

INSERT INTO schemes
(title, short_description, detailed_summary, category, target_group, state, language,
 official_url, apply_url, active)
VALUES
('Raitha Samparka Kendra',
 'Farmer support centers',
 'Provides advisory services and agricultural inputs to farmers.',
 'SUBSIDY',
 'FARMER',
 'KARNATAKA',
 'kn',
 'https://raitamitra.karnataka.gov.in',
 'https://raitamitra.karnataka.gov.in',
 true),

('Krushi Bhagya Yojana',
 'Rainwater harvesting scheme',
 'Supports rainwater harvesting for dryland farmers.',
 'SUBSIDY',
 'FARMER',
 'KARNATAKA',
 'kn',
 'https://raitamitra.karnataka.gov.in',
 'https://raitamitra.karnataka.gov.in',
 true);


INSERT INTO schemes
(title, short_description, detailed_summary, category, target_group, state, language,
 official_url, apply_url, active)
VALUES
('Bhavantar Bhugtan Yojana',
 'Price difference compensation',
 'Compensates farmers for price differences in selected crops.',
 'FINANCIAL',
 'FARMER',
 'MADHYA PRADESH',
 'hi',
 'https://mpkrishi.mp.gov.in',
 'https://mpkrishi.mp.gov.in',
 true),

('Mukhyamantri Kisan Kalyan Yojana',
 'Income support to farmers',
 'Provides financial assistance to farmers in Madhya Pradesh.',
 'FINANCIAL',
 'FARMER',
 'MADHYA PRADESH',
 'hi',
 'https://mpkrishi.mp.gov.in',
 'https://mpkrishi.mp.gov.in',
 true);

INSERT INTO schemes
(title, short_description, detailed_summary, category, target_group, state, language,
 official_url, apply_url, active)
VALUES
('Kuruvai Special Assistance',
 'Short-term crop assistance',
 'Provides financial assistance for Kuruvai crop farmers.',
 'FINANCIAL',
 'FARMER',
 'TAMIL NADU',
 'ta',
 'https://www.tn.gov.in',
 'https://www.tn.gov.in',
 true),

('Chief Minister’s Farmers Security Scheme',
 'Social security for farmers',
 'Provides pension and insurance benefits to farmers.',
 'INSURANCE',
 'FARMER',
 'TAMIL NADU',
 'ta',
 'https://www.tn.gov.in',
 'https://www.tn.gov.in',
 true);

INSERT INTO schemes
(title, short_description, detailed_summary, category, target_group, state, language,
 official_url, apply_url, active)
VALUES
('Mukhyamantri Krishak Sathi Yojana',
 'Farmer welfare scheme',
 'Provides financial and insurance benefits to farmers.',
 'FINANCIAL',
 'FARMER',
 'RAJASTHAN',
 'hi',
 'https://rajkisan.rajasthan.gov.in',
 'https://rajkisan.rajasthan.gov.in',
 true),

('Raj Kisan Saathi Portal',
 'Single window farmer services',
 'Provides access to multiple agriculture schemes.',
 'SUBSIDY',
 'FARMER',
 'RAJASTHAN',
 'hi',
 'https://rajkisan.rajasthan.gov.in',
 'https://rajkisan.rajasthan.gov.in',
 true);
 
 SELECT * FROM equipment_images;

