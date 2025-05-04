# -*- coding: utf-8 -*-

from odoo import models, fields, api


class Tender(models.Model):
    _name = "tender.tender"
    
    # Fields
    tender_code = fields.Char(required=True)
    name = fields.Text(required=True)
    region = fields.Many2one('res_region', string="Region", required=False)
    bidders = fields.Many2many('bidding.bidder', string="Participating Bidders", required=True)
    notes = fields.Text()
    content = fields.Html()
    application_period = fields.Datetime()
    tender_routes = fields.Many2many('tender.route')
    status = fields.Selection([
        ('draft', 'Draft'),
        ('sent', 'Sent to Bidders'),
        ('open', 'Open for Submission'),
        ('closed', 'Closed'),
    ], default='draft')

    # Methods
    def send_invitation(self):
        pass

    def bidders_confirm(self):
        pass


class Bidder(models.Model):
    _name = "bidding.bidder"
    
    name = fields.Char(required=True)
    contact_person = fields.Many2one('res_partner')
    email = fields.Char(required=True)
    phone = fields.Char(string="Số điện thoại")
    address = fields.Text()


class TenderDeadline(models.Model):
    _name = "tender.deadline"
    
    tender_id = fields.Many2one('tender.tender')
    deadline_date = fields.Datetime(required=True)
    description = fields.Text()
    action_type = fields.Selection([
        ('invitation', 'Send Invitation'),
        ('bid_submission', 'Bid Submission Deadline'),
        ('evaluation', 'Evaluation Deadline'),
        ('result_announcement', 'Result Announcement'),
    ], required=True)

    def send_reminder(self):
        pass


class TenderTemplate(models.Model):
    _name = "tender.template"
    
    template_name = fields.Char(required=True)
    content = fields.Html()
    attached_documents = fields.Many2many('document.document')

